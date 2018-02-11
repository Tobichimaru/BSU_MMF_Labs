
using System;
using System.Collections;
using System.Collections.Generic;

namespace QueueLib
{
    public class CustomQueue<T> : IEnumerable<T>
    {
        public CustomQueue()
        {
            Clear();
        } 

        public bool IsEmpty()
        {
            return (length == 0);
        }

        public int Length()
        {
            return length;
        }

        public void Clear()
        {
            maxLength = 8;
            elems = new T[maxLength];
            begin = 0;
            end = -1;
        }

        public void Enqueue(T key)
        {
            end = (end + 1) % maxLength;
            elems[end] = key;
            length++;

            if (length == maxLength)
                ExtendQueue();
        }

        public T Dequeue()
        {
            if (IsEmpty()) throw new NullReferenceException();
            
            length--;
            T key = elems[begin];
            begin = (begin + 1)%maxLength;
            return key;
        }

        public T Peek()
        {
            if (IsEmpty()) throw new NullReferenceException();
            return elems[begin];
        }

        public IEnumerator<T> GetEnumerator()
        {
            if (IsEmpty())
                yield break;
            if (begin < end)
            {
                for (int i = begin; i <= end; i++)
                    yield return elems[i];
            }
            else
            {
                for (int i = begin; i < maxLength; i++)
                    yield return elems[i];
                for (int i = 0; i <= end; i++)
                    yield return elems[i];
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
        
        private void ExtendQueue()
        {
            maxLength *= 2;
            T[] newElems = new T[maxLength];

            if (begin <= end)
            {
                Array.Copy(elems, begin, newElems, 0, length);
            }
            else
            {
                Array.Copy(elems, begin, newElems, 0, elems.Length - begin);
                Array.Copy(elems, 0, newElems, elems.Length - begin, end + 1);
            }

            elems = newElems;
        }

        private T[] elems;
        private int maxLength;
        private int length;
        private int begin;
        private int end;
    }
}
