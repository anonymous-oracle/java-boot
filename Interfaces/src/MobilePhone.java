public class MobilePhone implements ITelephone {
    private int myNumber;
    private boolean isRinging;
    private boolean isOn = false;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }

    public int getThisNumber() {
        return this.myNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("Mobile phone powered up");
        this.isOn = true;
    }

    @Override
    public void dial(int phoneNumber) {
        if (this.isOn) {
            System.out.println("Now ringing " + phoneNumber + " on mobile phone.");
        } else {
            System.out.println("Phone is switched off");
        }

    }

    @Override
    public void answer() {
        if (this.isRinging) {
            System.out.println("Answering the mobile phone");
            this.isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == this.myNumber && this.isOn) {
            this.isRinging = true;
            System.out.println("Melody ring");
        } else {
            this.isRinging = false;
            System.out.println("Mobile phone not on or number is incorrect");
        }
        return this.isRinging;
    }

    @Override
    public boolean isRinging() {
        return this.isRinging;
    }

}
