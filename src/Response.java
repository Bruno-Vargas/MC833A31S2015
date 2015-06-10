public class Response implements java.io.Serializable { 
    
    private String data; 
    private long time; 
   
    public Response(String data, long time) { 
        this.data = data; 
        this.time = time; 
    } 

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public String toString() {
        return data + "|" + time;
    }
} 