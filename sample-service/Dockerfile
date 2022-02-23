FROM lolhens/ammonite:2.5.2
EXPOSE 9000
ENV COURSIER_CACHE=/root/.ammonite/cache/coursier
VOLUME /root/.ammonite/cache
ENV JAVA_OPTS="-Dconfig.file=/application.conf"
ADD App.sc /
ADD application.conf /
CMD amm /App.sc
