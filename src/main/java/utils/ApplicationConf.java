package utils;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

public class ApplicationConf {
  private static final String APPLICATION_CONFIGURATION_FILE_NAME_DEFAULT = "application.properties";
  private static final String APPLICATION_CONFIGURATION_FILE_NAME = "src/main/resources/application.properties";
  private static final CompositeConfiguration config = new CompositeConfiguration();
  static {
    config.addConfiguration(new SystemConfiguration());
    try {
      config.addConfiguration(new PropertiesConfiguration(APPLICATION_CONFIGURATION_FILE_NAME));
    } catch (ConfigurationException e) {
      try {
        config.addConfiguration(new PropertiesConfiguration(APPLICATION_CONFIGURATION_FILE_NAME_DEFAULT));
      }catch (ConfigurationException e2) {
        System.out.println("cannot find conf file");
      }

    }
  }

  static public CompositeConfiguration getConfig()
  {
    return config;
  }
}
