/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author archivos
 */
public class XML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
        File archivoXML= new File("XML1.xml");
        Document documentoXML;
        DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        
        documentoXML = dBuilder.newDocument();
        Element raiz=documentoXML.createElement("raiz");
        documentoXML.appendChild(raiz);
        Element nombre = documentoXML.createElement("nombre");
        raiz.appendChild(nombre);
        Text textoNombre=documentoXML.createTextNode("Persona");
        nombre.appendChild(textoNombre);
        DOMSource source= new DOMSource(documentoXML);
          //transoramcion todos los nodos a XML
        TransformerFactory tFact=TransformerFactory.newInstance();
        Transformer trans= tFact.newTransformer();
        
        StringWriter resultadoEnCadena=new StringWriter();
        StreamResult resultado=new StreamResult(resultadoEnCadena);
        trans.transform(source, resultado);
        String xmlEnCadena= resultadoEnCadena.toString();
             System.out.println(xmlEnCadena);
//        documentoXML = dBuilder.parse(archivoXML);/// aca empieza a leer el archivo
//        /*//////////////
//        comienza los nodos
//        *////////////
//           
//        documentoXML.getDocumentElement().normalize();/////raiz(nodo principal), normalize(organizar)
//        
//        Element agenda = documentoXML.getDocumentElement();
//        NodeList hijosAgenda= agenda.getChildNodes();
//        System.out.println("Elemento Raiz: "+documentoXML.getDocumentElement().getTagName());
////             for (int i = 0; i < hijosAgenda.getLength(); i++) {
////                 Node hijo =hijosAgenda.item(i);
////                 NodeList aux;
////                 if(hijo.getNodeType()==Node.ELEMENT_NODE){
////                    System.out.println(hijo.getNodeName());
////                    aux=hijosAgenda.item(i).getChildNodes();
////                     for (int j = 0; j < aux.getLength(); j++) {
////                        Node hijos =aux.item(i);
////                        if(hijos.getNodeType()==Node.ELEMENT_NODE){
////                            System.out.println(hijos.getNodeName());
////                       }  
////                     }
////                 }
////                     
////                 
////             }
//        NodeList contactoAgenda=agenda.getElementsByTagName("contacto");
//             for (int i = 0; i < contactoAgenda.getLength(); i++) {
//                 Node contacto= contactoAgenda.item(i);
//                 System.out.println(contacto.getNodeName());
//                 Element eContacto =(Element)contacto;
//                 NodeList nombresContacto=eContacto.getElementsByTagName("nombre");
//                 for (int j = 0; nombresContacto.getLength() < 10; j++) {
//                    Node nombres=nombresContacto.item(j);
//                     System.out.println(nombres.getTextContent());
//                 }
//             }
             
        } catch (ParserConfigurationException ex) {
            System.out.println("No es XML");
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
//         catch (SAXException ex) {
//            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
//        } 
         catch (TransformerConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
