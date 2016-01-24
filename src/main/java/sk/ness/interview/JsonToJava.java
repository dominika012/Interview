package sk.ness.interview;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sk.ness.interview.domain.Article;

/**
 * Class should be used as parsing tool for {@link Article} array from file in resources consist of Json objects.
 *
 * @author michal.kmetka
 *
 */

public class JsonToJava {

    public Article[] converted(){
        try(Reader reader = new InputStreamReader(JsonToJava.class.getResourceAsStream("/articles_to_ingest.txt"), "UTF-8")){
            Gson gson = new GsonBuilder().create();
            Article[] articles = gson.fromJson(reader, Article[].class);
            return articles;
        } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
}
