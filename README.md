## How to reproduce

1. Build `shadowJar`

```bash
./gradlew :app:shadowJar
java -jar ./jars/ExposedGradleFail-bukkit-1.0.0.jar
```

See logs same as in [logs.txt](logs.txt)

```
Exception in thread "main" java.lang.AssertionError: Built-in class com.makeevrserg.exposedgradlefail.kotlin.Any is not found
```

After ShadowJar relocating, it would not be able to find kotlin.Any

## Important
The problem seems to happen after adding `.nullable()` inside Table()
