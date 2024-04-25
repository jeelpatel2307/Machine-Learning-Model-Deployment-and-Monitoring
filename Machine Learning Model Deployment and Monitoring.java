import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

public class ModelLoader {

    private SavedModelBundle model;

    public ModelLoader(String modelPath) {
        this.model = SavedModelBundle.load(modelPath, "serve");
    }

    public float predict(float[] input) {
        try (Session session = model.session()) {
            Tensor<Float> inputTensor = Tensor.create(input, Float.class);
            Tensor<Float> outputTensor = session.runner()
                    .feed("input", inputTensor)
                    .fetch("output")
                    .run()
                    .get(0)
                    .expect(Float.class);
            float prediction = outputTensor.copyTo(new float[1])[0];
            return prediction;
        }
    }
}







import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PredictionController {

    private final ModelLoader modelLoader;

    public PredictionController(ModelLoader modelLoader) {
        this.modelLoader = modelLoader;
    }

    @PostMapping("/predict")
    public float predict(@RequestBody float[] input) {
        return modelLoader.predict(input);
    }
}







import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ModelLoader modelLoader() {
        return new ModelLoader("path/to/your/saved_model");
    }
}
