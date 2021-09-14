import java.util.*;

public class keepTyping
{
    static public void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter anything");
        String res = s.nextLine();
        s.close();

        String draft = "";
        String chkr = draft;
        String alchr = "qwertyuiopasdfghjklzxcvbnm QWERTYUIOPASDFGHJKLZXCVBNM 1234567890 `~ !@#$%^&*() -=_+ []\\;\"',./ {}|:<>?";
        int warn = 0;
        int tim = 0;
        boolean run = true;

        System.out.println("  Please wait untill it prints '"+res+"'");
        while (run == true)
        {
            warn++;

            if(warn%20 == 0)
            {
                tim++;
                tim++;

                System.out.println("\n  Time wasted: " + tim + "seconds \n");
            }

            char ad = alchr.charAt(randnum());

            try
            {
                Thread.sleep(100);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }

            draft += ad;

            if(draft.equals(res))
                System.out.println("Finally, there you go... \n >> "+draft+" <<");
            else
                System.out.println(draft);

            if (res.startsWith(draft) == true)
                chkr = draft;
            else
                draft = chkr;

            if (chkr.equals(res))
                run = false;
        }

        String actualtime = calcTim(tim, warn);

        System.out.println("\n By the way... \n Thanks for wasting " + actualtime +" :)");
    }

    private static int randnum()
    {
        Random rand =  new  Random();
        int r = rand.nextInt(101);
        return r;
    }

    private static String calcTim(int sec, int mil)
    {
        String actualtime = "";
        int hr = 0;
        int min = 0;

        mil = mil>99 ? mil%100 : 0;

        while (sec >= 60)
        {
            min++;
            sec -= 60;
        }

        while (min >= 60)
        {
            hr++;
            min -= 60;
        }

        if (hr > 0)
        {
            if (hr > 1)
                actualtime = hr+" hours, "+min+" minutes and "+sec+"."+mil+" seconds";
            else
            {
                if (min > 1)
                    actualtime = hr+" hour, "+min+" minutes and "+sec+"."+mil+" seconds";
                else
                {
                    actualtime = hr+" hour, "+min+" minute and "+sec+"."+mil+" seconds";
                }
            }
        }
        else if (min > 0)
        {
            if (min > 1)
                if(sec > 1)
                    actualtime = min+" minutes and "+sec+" seconds";
                else
                {
                    actualtime = min+" minutes and "+sec+" second";
                }
            else
            {
                if(sec > 1)
                    actualtime = min+" minute and "+sec+" seconds";
                else
                {
                    actualtime = min+" minute and "+sec+" second";
                }
            }
        }
        else if (mil > 0)
        {
            actualtime = sec+"."+mil+" seconds";
        }
        else
        {
            if(sec > 1)
                actualtime = sec+" seconds";
            else
            {
                actualtime = sec+" second";
            }
        }

        return actualtime;
    }
}