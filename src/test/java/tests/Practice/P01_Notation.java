package tests.Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class P01_Notation {

    @Test
    public void ANergiz(){
        System.out.println("Nergiz");
    }

    @Test
    public void TOmer(){
        System.out.println("Ömer");
    }

    @Test @Ignore
    public void ESenol(){
        System.out.println("Şenol");
    }

    @Test (dependsOnMethods = "ANergiz")
    public void ZBugra(){
        System.out.println("Buğra");
    }
}
