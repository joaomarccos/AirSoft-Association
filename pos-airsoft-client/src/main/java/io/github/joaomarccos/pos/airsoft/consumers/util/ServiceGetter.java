package io.github.joaomarccos.pos.airsoft.consumers.util;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
public class ServiceGetter {

    /**
     * obtém uma instância de <javax.xml.ws.Service>
     * @param url
     * @param nameSpace
     * @param serviceName
     * @return
     * @throws java.net.MalformedURLException
     */
    public static Service getService(String url, String nameSpace, String serviceName) throws MalformedURLException {

        URL wsdl = new URL(url);
        QName qname = new QName(nameSpace, serviceName);
        Service ws = Service.create(wsdl, qname);
        return ws;

    }
}
