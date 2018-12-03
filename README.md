# Translator Text API V3 - .NET Core Samples, Java

This repository includes Java samples for Microsoft Translator. Each sample corresponds to a **Quickstart** activity on [doc.microsoft.com](https://docs.microsoft.com/azure/cognitive-services/translator/), including:

* [Translating text](https://docs.microsoft.com/azure/cognitive-services/translator/quickstart-java-translate)
* [Transliterating text](https://docs.microsoft.com/azure/cognitive-services/translator/quickstart-java-transliterate)
* [Identifying the language of source text](https://docs.microsoft.com/azure/cognitive-services/translator/quickstart-java-detect)
* [Getting alternate translations](https://docs.microsoft.com/azure/cognitive-services/translator/quickstart-java-dictionary)
* [Getting a complete list of supported languages](https://docs.microsoft.com/azure/cognitive-services/translator/quickstart-java-languages)
* [Determining sentence length](https://docs.microsoft.com/azure/cognitive-services/translator/quickstart-java-sentences)

## Prerequisites

* [JDK 7 or later](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Gradle](https://gradle.org/install/)
* An Azure subscription key for Translator Text

## Code samples

This repository includes a sample for each of the methods made available by the Microsoft Translator Text API v3. To use each of the samples, follow the instructions below.

**Important note**: The directory for each sample includes a Gradle build configuration.

* Create a working directory for your project. For example: `mkdir sample-project`.
* Initialize your project with Gradle: `gradle init --type basic`. When prompted to choose a **DSL**, select **Kotlin**.
* Update `build.gradle.kts` with the configuration provided in the sample directory.
* Create a Java file and copy in the code from the provided sample. Don't forget to add your subscription key.
* Run the sample: `gradle run`.

## Resources

* [What is the Translator Text API?](https://docs.microsoft.com/azure/cognitive-services/translator/translator-info-overview)
* [v3 Translator Text API Reference](https://docs.microsoft.com/azure/cognitive-services/translator/)
* [Supported languages](https://docs.microsoft.com/azure/cognitive-services/translator/language-support)
