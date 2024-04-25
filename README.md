# Machine Learning Model Deployment and Monitoring in Java

This project demonstrates how to deploy and monitor machine learning models in Java using Spring Boot for creating APIs and Micrometer for monitoring.

## Components

1. **ModelLoader.java**: Loads the serialized machine learning model using TensorFlow's SavedModelBundle.
2. **PredictionController.java**: Exposes REST API endpoints for making predictions.
3. **Application.java**: Main class to run the Spring Boot application.

## Usage

1. Serialize your machine learning model using TensorFlow or another framework and save it in the SavedModel format.
2. Update the `ModelLoader` class with the path to your serialized model.
3. Run the Spring Boot application by executing the `Application` class.
4. Use HTTP POST requests to the `/predict` endpoint with input data to make predictions.

## Dependencies

- Spring Boot: A framework for building Java-based enterprise applications.
- TensorFlow: An open-source machine learning framework for training and serving models.
- Micrometer: A metrics collection toolkit for application monitoring.

## Contributing

Contributions are welcome! If you have any ideas for improvements or new features, feel free to open an issue or submit a pull request.

## Credits

This project was created by Jeel patel.
