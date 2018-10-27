package edu.project3;

import java.util.ArrayList;

public class CallLog {

    private ArrayList<CallInfo> callHistoryInfo;

    public CallLog() {

        this.callHistoryInfo = new ArrayList();

    }

    public void addCall(CallInfo callHistory) {
        this.callHistoryInfo.add(callHistory);

    }

    public void allHistory() {
        ArrayList<CallInfo> uniqueCalls = new ArrayList();
        for(CallInfo elt : callHistoryInfo) {
            if(searchCall(elt.getNumber(),uniqueCalls).size() == 0) {
                uniqueCalls.add(elt);
            }
        }
        for(CallInfo elt2 : uniqueCalls) {
            if(searchCall(elt2.getNumber(),callHistoryInfo).size() > 1) {
                if(elt2.getName().equals("")) {
                    System.out.printf("%-20s (%d)%n",elt2.getNumber(),searchCall(elt2.getNumber(),callHistoryInfo).size());
                }else {
                    System.out.printf("%-20s (%d)%n",elt2.getName(),searchCall(elt2.getNumber(),callHistoryInfo).size());
                }
            }else {
                System.out.println(elt2);
            }
        }
    }


    public void findCalls(String person) {
        ArrayList<Integer> indexArray = searchCall(person,callHistoryInfo);
        if(indexArray.size() < 1) {
            System.out.println("There have been no calls made to/from this person");
        }else {
            for(int elt : indexArray)
                System.out.println(this.callHistoryInfo.get(elt));
        }
    }

    public ArrayList<Integer> searchCall(String searchee, ArrayList<CallInfo> array) {
        ArrayList<Integer> output = new ArrayList();
        for (CallInfo element : array) {
            if(element.getNumber().equals(searchee)) {
                output.add(array.indexOf(element));
            }

        }
        return output;
    }
}
