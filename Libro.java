import java.util.*;
import org.w3c.dom.*;
import javax.xml.xpath.*;
import javax.xml.parsers.*;
//*Autor: Raul Ernesto Perez Barcenas*//
//*Matricula: 148661*//
//*Version: 1.0*//
//*Asignatura: Programacion Integrativa (UACJ)*//
public class Libro
{
  public static void main(String[] args) throws Exception
  {
    //Build DOM
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse("books.xml");
    //Create XPath
    XPathFactory xpathfactory = XPathFactory.newInstance();
    XPath xpath = xpathfactory.newXPath();
    //a. Nombre del autor del libro de Horror.
    XPathExpression expr = xpath.compile("//book[genre='Horror']/author/text()");
    Object result = expr.evaluate(doc, XPathConstants.NODESET);
    NodeList nodes = (NodeList) result;
    for (int i = 0; i < nodes.getLength(); i++)
    {
        System.out.println("El autor del libro de Horror es: ");
        System.out.println(nodes.item(i).getNodeValue());
    }
    //b. Total de comprar todos los libros de fantasia,
    expr = xpath.compile("sum(//book[genre='Fantasy']/price)");
    result = expr.evaluate(doc, XPathConstants.NUMBER);
    Double count = (Double) result;
    System.out.println("Total de compra de libros de Fantasia:  ");
    System.out.println(count);
    //c. lista de libros de Microsoft (Winderos)
    expr = xpath.compile("//book[contains(description,'Microsoft')]");
    result = expr.evaluate(doc, XPathConstants.NODESET);
    nodes = (NodeList) result;
    for (int i = 0; i < nodes.getLength(); i++)
    {
        System.out.println("Detalles libros de Microsoft: ");
        System.out.println(nodes.item(i).getTextContent());
    }
  }
}
