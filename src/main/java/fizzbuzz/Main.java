/*
Copyright 2012 Yusuke Yamamoto

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
Distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package fizzbuzz;

import twitter4j.*;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        final Twitter twitter = TwitterFactory.getSingleton();
        final TwitterStream stream = TwitterStreamFactory.getSingleton();
        stream.addListener(new UserStreamAdapter() {
            public void onStatus(Status status) {
                String response = fizzBuzz(status.getText());
                if (!response.isEmpty()) {
                    try {
                        StatusUpdate update = new StatusUpdate("@"+status.getUser().getScreenName()+" "+response)
                                .inReplyToStatusId(status.getId());
                        twitter.updateStatus(update);
                    } catch (TwitterException ignore) {
                    }
                }
            }
        });
        stream.user();
    }

    final static Pattern pattern = Pattern.compile("[0-9]+");

    public static String fizzBuzz(String text) {
        String response = "";
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String numStr = matcher.group();
            BigInteger num = new BigInteger(numStr);
            if (num.remainder(new BigInteger("3")).equals(BigInteger.ZERO)) {
                response = "Fizz";
            }
            if (numStr.endsWith("5") || numStr.endsWith("0")) {
                response+=" Buzz";
            }
        }
        return response.trim();
    }
}
