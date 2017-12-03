package utilities;

public class DateCompound {

    private int year, month, day;

    public DateCompound(String date){
        this.month = Integer.parseInt(date.substring(0,2));
        this.day = Integer.parseInt(date.substring(2,4));
        this.year = Integer.parseInt(date.substring(4,8));
    }

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public String asString(){
        return month + "/" + day + "/" + year;
    }

    public boolean equal(DateCompound date){
        if(date.getYear() == getYear()){
            if(date.getMonth() == getMonth()){
                if(date.getDay() == getDay()){
                    return true;
                }
            }
        }
        return false;
    }

}
