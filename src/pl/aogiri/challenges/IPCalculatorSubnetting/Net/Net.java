package pl.aogiri.challenges.IPCalculatorSubnetting.Net;

import java.util.Arrays;

public class Net {
    private String network;
    private String netmask;
    private String broadcast;
    private String firstHost;
    private String lastHost;
    private int hosts;

    public Net() {
    }

    public Net(String host, String netmask) {
        this.netmask = netmask;
        calculate(host,netmask);
    }

    private void calculate(String host,String netmask){
        char[] hostT = toBinnary(host).toCharArray();
        char[] netmaskT = toBinnary(netmask).toCharArray();
        char[] network = Arrays.copyOf(hostT,hostT.length);
        char[] broadcast = Arrays.copyOf(hostT,hostT.length);
        for(int i = 0 ; i<hostT.length;i++){
            if(netmaskT[i]=='0') {
                network[i] = '0';
                broadcast[i] = '1';
            }
        }
        this.network = toDecimal(new String(network));
        this.broadcast = toDecimal(new String(broadcast));

        String[] firstH = toDecimal(new String(network)).split("\\.");
        firstH[3] = String.valueOf(Integer.valueOf(firstH[3])+1);
        this.firstHost = String.join(".",firstH);

        String[] lastH = toDecimal(new String(broadcast)).split("\\.");
        lastH[3] = String.valueOf(Integer.valueOf(lastH[3])-1);
        this.lastHost = String.join(".",lastH);
    }


    private String toBinnary(String ip){
        String[] temp = ip.split("\\.");
        for(int i = 0 ; i<temp.length ; i++){
            temp[i] = complete(Integer.toBinaryString(Integer.valueOf(temp[i])));
        }
        return String.join(".", temp);
    }

    private String toDecimal(String ip){
        String[] temp = ip.split("\\.");
        for(int i = 0 ; i<temp.length ; i++){
            temp[i] = String.valueOf(Integer.parseInt(temp[i],2));
        }
        return String.join(".", temp);
    }

    private String complete(String x){
        if(x.length()<8){
            StringBuilder y = new StringBuilder(x);
            for(int i = x.length() ; i<8 ; i++){
                y.insert(0,"0");
            }
            x = y.toString();
        }
        return x;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getNetmask() {
        return netmask;
    }

    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getFirstHost() {
        return firstHost;
    }

    public void setFirstHost(String firstHost) {
        this.firstHost = firstHost;
    }

    public String getLastHost() {
        return lastHost;
    }

    public void setLastHost(String lastHost) {
        this.lastHost = lastHost;
    }

    public int getHosts() {
        return hosts;
    }

    public void setHosts(int hosts) {
        this.hosts = hosts;
    }
}
