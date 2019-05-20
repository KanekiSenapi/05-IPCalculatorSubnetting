package pl.aogiri.challenges.IPCalculatorSubnetting.Net;

import java.util.HashSet;
import java.util.Set;

public class IPAddress {
    private StringBuilder octetsBinnary = new StringBuilder();

    public IPAddress() {
    }

    public IPAddress(String ip) {
        String[] temp = ip.split(".");
        for(String octet : temp){
            octetsBinnary.append(Integer.toBinaryString(new Integer(octet)));
        }
    }

    public String getIPAddressDec(){
        StringBuilder temp = new StringBuilder();
        for(String octet : octetsBinnary.toString().split(".")){
            temp.append(Integer.parseInt(octet,2));
        }
        return temp.toString();
    }

    public String getIPAddressBin(){
        return octetsBinnary.toString();
    }


}
