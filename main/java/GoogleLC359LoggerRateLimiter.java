package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joyfeng on 11/26/2016.
 */
public class GoogleLC359LoggerRateLimiter {
    private Map<String, Integer> map;
    /** Initialize your data structure here. */
    public GoogleLC359LoggerRateLimiter() {
        map = new HashMap<String, Integer>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            int ts = map.get(message);
            if ((timestamp-ts) >= 10) {  // !! remember you also have to update timestamp now

                map.put(message, timestamp);
            }
            // more concise version
            // if(!msg.containsKey(message) || timestamp-msg.get(message)>=10){
            //      msg.put(message, timestamp);
            //      return true;
            //  }else{
            //      return false;
            //  }

            return (timestamp-ts) >= 10;
        } else {
            map.put(message, timestamp);
        }
        return true;
    }
}
