package com.gamers.SequenceGenerators;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.hibernate.type.spi.TypeConfiguration;


import java.io.Serializable;
import java.util.Properties;

public class GameIDSeqGenerator extends SequenceStyleGenerator {

    public static final String PREFIX_PARAM = "Prefix";
    public static final String PREFIX_PARAM_DEFAULT = "";
    private String prefix;

    public static final String NUMBER_FORMAT_PARAM = "numberFormat";
    public static final String NUMBER_FORMAT_PARAM_DEFAULT = "%d";
    private String numberFormat;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return prefix + String.format(numberFormat,super.generate(session,object));
    }


    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {

        super.configure(new TypeConfiguration().getBasicTypeRegistry().getRegisteredType(Long.class), params, serviceRegistry);
        prefix = ConfigurationHelper.getString(PREFIX_PARAM,params,PREFIX_PARAM_DEFAULT);
        numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAM,params,NUMBER_FORMAT_PARAM_DEFAULT);

    }



}
