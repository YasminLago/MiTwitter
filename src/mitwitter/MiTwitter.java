/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mitwitter;

import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


/**
 *
 * @author mmoureperez
 */
public class MiTwitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TwitterException {
        // TODO code application logic here
        
       // ConfigurationBuilder cb = new ConfigurationBuilder();
        //La configurationBuilder paso a un fichero. 
      
        
        Twitter twitter = new TwitterFactory().getInstance();
        
        //CODIGO CAMBIAR ESTADO
        Status miStatus = twitter.updateStatus("Tercer ejemplo");//cambia el estado de twitter
        System.out.println(miStatus.getText());

        //CODIGO TIMELINE
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");//aparecen los ultimos twitts
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" + status.getText());
        }

        //CODIGO BUSCAR TAGS
        Query query = new Query("Chelsea"); //Dentro del String va el tag que quieres buscar
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
        

    }
    
}
