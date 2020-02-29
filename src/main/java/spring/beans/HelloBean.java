package spring.beans;

public class HelloBean {

    private String name;

    private String message;

    public HelloBean(String nameIn , String messageIn){
        name = nameIn;
        message = messageIn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameIn) {
        this.name = nameIn;
    }


}

