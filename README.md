# software-testing-offutt-mujava
Docker container with pre-configured muJava for mutation testing based on Offutt's Software Testing textbook. Ready-to-run setup with examples, enabling quick experimentation with Java mutation testing techniques.

Commands and files downloaded from https://cs.gmu.edu/~offutt/mujava/ to execute the project.

Requirements:
- Docker
- Docker compose
- WSL (if Windows)

For Windows Users in WSL:
```sh
sudo apt install x11-xserver-utils x11-apps
```

In the project folder, run:
```sh
docker compose build
```

Allow `xhost` connections for GUI:
```sh
xhost +local:docker
```

Enter the container to run commands:
```sh
docker compose run --rm -e DISPLAY=$DISPLAY -v /tmp/.X11-unix:/tmp/.X11-unix test-mujava /bin/bash
```

Setup the MuJava structure (if not already done):
```sh
java -cp "/code/mujava.jar:/code/openjava.jar" mujava.makeMuJavaStructure
```

Compile source file:
```sh
javac -d ./software_testing_mujava/classes software_testing_mujava/src/Cal.java
```

Compile test file:
```sh
javac -cp "/code/mujava.jar:/code/openjava.jar:/code/junit-4.13.2.jar:./software_testing_mujava/classes" -d ./software_testing_mujava/testset ./software_testing_mujava/testset/CalTest.java
```

Run JUnit test just to confirm:
```sh
java -cp "/code/mujava.jar:/code/openjava.jar:/code/junit-4.13.2.jar:/code/hamcrest-core-1.3.jar:./software_testing_mujava/classes:./software_testing_mujava/testset" org.junit.runner.JUnitCore CalTest
```

For generating the mutants:
```sh
java -cp "/code/mujava.jar:/code/openjava.jar:/opt/java/openjdk/lib/tools.jar" mujava.gui.GenMutantsMain
```

For testing the mutants:
````sh
java -cp "/code/mujava.jar:/code/openjava.jar:/code/junit-4.13.2.jar:/code/hamcrest-core-1.3.jar:/opt/java/openjdk/lib/tools.jar" mujava.gui.RunTestMain
```