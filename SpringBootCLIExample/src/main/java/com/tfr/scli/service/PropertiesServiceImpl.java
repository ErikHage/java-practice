package com.tfr.scli.service;

import com.tfr.scli.config.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Erik on 8/26/2016.
 */

@Service
public class PropertiesServiceImpl implements PropertiesService {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesServiceImpl.class);

    @Autowired
    private PropertiesReader props;

    @Override
    public com.tfr.scli.model.ServiceInfo getServiceInfo() {
        com.tfr.scli.model.ServiceInfo info = new com.tfr.scli.model.ServiceInfo();
        info.setName(props.getProperty("scli.name"));
        info.setDescription(props.getProperty("scli.description"));
        info.setVersion(props.getProperty("scli.version"));

        logger.debug(info.toString());

        return info;
    }
}
