FROM maven:3.8.2-eclipse-temurin-8

WORKDIR /code

#inutil?
ENV CLASSPATH="/code/mujava.jar:/code/openjava.jar"
ENV DISPLAY=localhost:0.0

RUN apt update && apt upgrade -y
RUN apt install -y libxrender1 libxtst6 libxi6

COPY . /code/
# RUN echo "X11Forwarding yes\nX11UseForwarding yes" >> /etc/ssh/ssh_config
# RUN systemctl restart sshd

CMD ["/bin/sh" "-c" "/bin/sh -c \"trap ':' TERM INT; sleep 3600 & wait\""]