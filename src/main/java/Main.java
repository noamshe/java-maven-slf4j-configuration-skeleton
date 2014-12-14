import org.slf4j.Logger;

public class Main {

  private static final Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    logger.trace("Hello TRACE");
    logger.debug("Hello DEBUG");
    logger.info("Hello INFO");
    logger.warn("Hello WARN");
    logger.error("Hello ERROR");
  }
}
