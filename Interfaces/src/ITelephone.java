public interface ITelephone {

    // public modifier is redundant for interface class as they anyway have to be an interface for class methods
    void powerOn();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    boolean isRinging();
    

}
