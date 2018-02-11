using System;
using System.Configuration;
using System.Diagnostics;

namespace MathExtension
{
    public class Polynom : IEquatable<Polynom>, ICloneable
    {
        private readonly double[] coeff = {}; 
        private readonly static double eps;
        private int degree;

        static Polynom()
        {
            try
            {
                eps = Convert.ToDouble(ConfigurationManager.AppSettings["eps"]);
            }
            catch (ConfigurationErrorsException)
            {
                eps = 0.000001;
            }
        }

        public Polynom(params double[] coeff)
        {
            if (ReferenceEquals(coeff, null))
            {
                throw new ArgumentNullException();
            }
            this.coeff = new double[coeff.Length + 1];
            for (int i = 0; i < coeff.Length; i++)
            {
                this.coeff[i] = coeff[i];
            }
        }

        public double this[int i]
        {
            get
            {
                if (i > degree || i < 0)
                {
                    throw new ArgumentOutOfRangeException();
                }
                return coeff[i];
            }
            set
            {
                if (i > degree || i < 0)
                {
                    throw new ArgumentOutOfRangeException();
                }
                coeff[i] = value;
                if (Math.Abs(value) < eps && i == degree)
                {
                    CalculateDegree();
                }
            }
        }

        private void CalculateDegree()
        {
            int i = coeff.Length - 1;
            if (i > -1)
            {
                while (Math.Abs(coeff[i]) < eps && i >= 0) i--;
            }
            degree = i;
        }
        
        public static Polynom operator +(Polynom lhs, Polynom rhs)
        {
            if (ReferenceEquals(lhs, null) || ReferenceEquals(rhs, null))
            {
                throw new ArgumentNullException();
            }
            int resultdegree = Math.Max(rhs.degree, lhs.degree);
            double[] resultCoeff = new double[resultdegree + 1];
            for (int i = 0; i <= lhs.degree; i++)
            {
                resultCoeff[i] = lhs[i];
            }
            for (int i = 0; i <= rhs.degree; i++)
            {
                resultCoeff[i] += rhs[i];
            }
            return new Polynom(resultCoeff);
        }

        public static Polynom Add(Polynom lhs, Polynom rhs)
        {
            return (lhs + rhs);
        }

        public static Polynom operator -(Polynom polynom)
        {
            if (ReferenceEquals(polynom, null))
            {
                throw new ArgumentNullException();
            }
            double[] resultCoeff = new double[polynom.degree + 1];
            for (int i = 0; i <= polynom.degree; i++)
            {
                resultCoeff[i] = -polynom[i];
            }
            return new Polynom(resultCoeff);
        }

        public Polynom Subtract(Polynom lhs, Polynom rhs)
        {
            return lhs - rhs;
        }

        public static Polynom operator -(Polynom lhs, Polynom rhs)
        {
            if (ReferenceEquals(lhs, null) || ReferenceEquals(rhs, null))
            {
                throw new ArgumentNullException();
            }
            return lhs + (- rhs);
        }

        public static Polynom operator *(Polynom lhs, double alpha)
        {
            if (ReferenceEquals(lhs, null))
            {
                throw new ArgumentNullException();
            }
            Polynom rhs = new Polynom(alpha);
            return rhs*lhs;
        }

        public static Polynom operator *(double alpha, Polynom rhs)
        {
            return rhs*alpha;
        }

        //implicit conversion polynom -> double
        //explicit conversion double -> polynom

        public static Polynom operator *(Polynom lhs, Polynom rhs)
        {
            if (ReferenceEquals(lhs, null) || ReferenceEquals(rhs, null))
            {
                throw new ArgumentNullException();
            }
            int resultdegree = lhs.degree + rhs.degree;
            double[] resultCoeff = new double[resultdegree + 1];
            for (int i = 0; i <= lhs.degree; i++)
            {
                for (int j = 0; j <= rhs.degree; j++)
                {
                    resultCoeff[i + j] += lhs[i] * rhs[j];
                }
            }
            return new Polynom(resultCoeff);
        }

        public Polynom Multiply(Polynom lhs, Polynom rhs)
        {
            return lhs * rhs;
        }

        public override int GetHashCode()
        {
            unchecked
            {
                return ((coeff != null ? coeff.GetHashCode() : 0) * 397) ^ degree;
            }
        }

        public Polynom Clone()
        {
            return new Polynom(coeff);
        }

        object ICloneable.Clone()
        {
            return Clone();
        }

        public override bool Equals(Object obj)
        {
            if (ReferenceEquals(obj, null))
            {
                return false;
            }
            if (ReferenceEquals(obj, this))
            {
                return true;
            }
            Polynom p = obj as Polynom;
            if (p == null)
            {
                return false;
            }
            Polynom polynom = (Polynom)obj;
            return Equals(polynom);
        }

        public bool Equals(Polynom polynom)
        {
            if (ReferenceEquals(polynom, null))
            {
                return false;
            }
            if (ReferenceEquals(polynom, this))
            {
                return true;
            }
            if (degree != polynom.degree)
            {
                return false;
            }
            for (int i = 0; i <= degree; i++)
            {
                if (Math.Abs(coeff[i] - polynom[i]) > eps) return false;
            }
            return true;
        }

        public override string ToString()
        {
            string result = "";
            int i = degree;
            while (i >= 0)
            {
                result += String.Format("{0:F20}", coeff[i].ToString()) + "*x^" + i.ToString();
                if (i > 0) result += " + ";
                i--;
            }
            return result;
        }

        public static bool operator ==(Polynom lhs, Polynom rhs)
        {
            if (ReferenceEquals(rhs, lhs))
            {
                return true;
            }
            if (ReferenceEquals(lhs, null))
            {
                return false;
            }
            return lhs.Equals(rhs);
        }

        public static bool operator !=(Polynom lhs, Polynom rhs)
        {
            return !(lhs == rhs);
        }
    }
}
