
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Card implements ISerialize {
    private String name;
    private String color;
    private int status;
    
    public Card() {
        status = 0;
    }

    public Card(String name,String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getStatus()
    {
        status = setStatus();
        return status;
    }

    public void show() {System.out.println("Last card is " + name + " of " + color);}


    public int setStatus() {
        if (name == "six")
        {
            return 1;
        }
        else if (name == "seven") {
            return 2;
        }
        else if (name == "king" && color == "spades")
        {
            return 5;
        }
        else if (name == "ace")
        {
            return -1;
        }
        return 0;
    }

    @Override
    public byte[] serialize() {
        byte[] byte_name = name.getBytes();
        byte[] byte_color = color.getBytes();
        ByteBuffer bb = ByteBuffer.allocate(3*4);
        bb.putInt(byte_name.length);
        bb.putInt(byte_color.length);
        bb.putInt(status);
        byte[] byte_status = bb.array();
        byte[] result = new byte[byte_name.length + byte_color.length + byte_status.length];
        System.arraycopy(byte_status, 0, result, 0, byte_status.length);
        System.arraycopy(byte_name, 0, result, byte_status.length, byte_name.length);
        System.arraycopy(byte_color, 0, result, byte_status.length + byte_name.length, byte_color.length);
        return result;
    }
    
    @Override
    public void deserialize(byte[] buffer) {
        byte[] byte_int = new byte[12];
        int color_length = 0, name_length = 0;
        System.arraycopy(buffer, 0, byte_int, 0, 12);
        ByteBuffer bb = ByteBuffer.wrap(byte_int);
        name_length = bb.getInt();
        color_length = bb.getInt();
        status = bb.getInt();
        byte[] byte_name = new byte[name_length];
        System.arraycopy(buffer, 12, byte_name, 0, name_length);
        byte[] byte_color = new byte[color_length];
        System.arraycopy(buffer, 12 + name_length, byte_color, 0, color_length);
        name = new String(byte_name, StandardCharsets.UTF_8);
        color = new String(byte_color, StandardCharsets.UTF_8);
    }
}
