package integration;

import nlp.ServicioPublicoTagger;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.net.URL;

    public class AppFile {

        public static void main(String[] args) throws Exception {

            StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

            URL url = AppFile.class.getClassLoader().getResource("tweets.json");

            DataStream<String> streamSource = env.readTextFile(url.getPath());

            Pipeline.process(streamSource);

            env.execute();
        }

    }