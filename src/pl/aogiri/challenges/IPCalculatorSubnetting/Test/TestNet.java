package pl.aogiri.challenges.IPCalculatorSubnetting.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.aogiri.challenges.IPCalculatorSubnetting.Net.Net;

public class TestNet {

    String exceptedNetwork = "83.142.157.0";
    String exceptedBroadcast = "83.142.157.255";
    String exceptedFirstHost = "83.142.157.1";
    String exceptedLastHost = "83.142.157.254";

    Net net = new Net("83.142.157.216", "255.255.255.0");
    String actualNetwork = net.getNetwork();
    String actualBroadcast = net.getBroadcast();
    String actualFirstHost = net.getFirstHost();
    String actualLastHost = net.getLastHost();

    @Test
    public void TestNetwork(){
        Assertions.assertEquals(exceptedNetwork, actualNetwork);
    }

    @Test
    public void TestBroadcast(){
        Assertions.assertEquals(exceptedBroadcast, actualBroadcast);
    }

    @Test
    public void TestFirstHost(){
        Assertions.assertEquals(exceptedFirstHost, actualFirstHost);
    }

    @Test
    public void TestLastHost(){
        Assertions.assertEquals(exceptedLastHost, actualLastHost);
    }
}
