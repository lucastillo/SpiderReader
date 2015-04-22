/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiderreader;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spider
{
  private static final int MAX_PAGES_TO_SEARCH = 100;
  private Set<String> pagesVisited = new HashSet<String>();
  private List<String> pagesToVisit = new LinkedList<String>();


  /**
   * Our main launching point for the Spider's functionality. Internally it creates spider legs
   * that make an HTTP request and parse the response (the web page).
   * 
   * @param url
   *            - The starting point of the spider
   * @param searchWord
   *            - The word or string that you are searching for
   */
  public void search(String url, String searchWord)
  {
      while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH)
      {
          String currentUrl;
          SpiderLeg leg = new SpiderLeg();
          if(this.pagesToVisit.isEmpty())
          {
              currentUrl = url;
              this.pagesVisited.add(url);
          }
          else
          {
              currentUrl = this.nextUrl();
          }
          
          leg.crawl(currentUrl); // ver el metodo de la clase spiderleg
          
          boolean success = leg.searchForWord(searchWord);
          if(success)
          {
              Pattern pat= Pattern.compile("^<p>(.*"+searchWord+".*)<p>$");
              Matcher mat= pat.matcher(leg.getHtmlDocument().body().text());
              while(mat.find()){
                  System.out.println(mat.group());                  
              }
              System.out.println(leg.getHtmlDocument().body().text());
              System.out.println(String.format("**Encontrada** La palabra %s encontrada en %s", searchWord, currentUrl));
              break;
          }
          this.pagesToVisit.addAll(leg.getLinks());
      }
      System.out.println("\n**Hecho** Se visistaron" + this.pagesVisited.size() + " páginas web");
  }


  /**
   * Returns the next URL to visit (in the order that they were found). We also do a check to make
   * sure this method doesn't return a URL that has already been visited.
   * 
   * @return
   */
  private String nextUrl()
  {
      String nextUrl;
      do
      {
          nextUrl = this.pagesToVisit.remove(0);
      } while(this.pagesVisited.contains(nextUrl));
      this.pagesVisited.add(nextUrl);
      return nextUrl;
  }
}