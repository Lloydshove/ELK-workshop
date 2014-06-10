package tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import everything.Event;
import org.apache.log4j.Logger;

import java.util.Map;

public class LogBuilder {

    public final Logger logger;

    private final StopWatch stopWatch;
    private final LogType type;
    private final String id;

    public LogBuilder(LogType type, String id, Class clasz) {
        this.type = type;
        this.id = id;
        this.stopWatch = new StopWatch();
        this.logger = Logger.getLogger(clasz);
    }

    public void logEventFor(Event spaceEvent, Map<String, Object> metaData) {
        if(spaceEvent == Event.Started){
            stopWatch.start();
        }

        Map<String, Object> content =
                ImmutableMap.<String, Object>of(
                        "Entity", type.name(),
                        "Id", id,
                        "Event", spaceEvent.name(),
                        "Duration", stopWatch.check(),
                        "MetaData", metaData);

        try {
            ObjectMapper mapper = new ObjectMapper();

            logger.info(mapper.writeValueAsString(content));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
