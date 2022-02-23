#!/usr/bin/env amm

import $ivy.{
  `com.typesafe.play::play:2.8.13`,
  `com.typesafe.play::play-akka-http-server:2.8.13`,
  `com.typesafe.play::play-logback:2.8.13`
}

import play.api.Mode
import play.api.mvc._
import play.api.routing.sird._
import play.core.server.{AkkaHttpServer, ServerConfig}

// object wrapping is needed: https://github.com/com-lihaoyi/Ammonite/issues/802
object Server {
  val run = AkkaHttpServer.fromRouterWithComponents(ServerConfig(mode = Mode.Dev)) { components =>
    import Results._
    import components.{ defaultActionBuilder => Action }
    {
      case GET(p"/hello/$to") =>
        Action {
          sys.env.get("POD_NAME") match {
            case Some(podName) =>
              Ok(s"Hello $to from k8s POD: $podName")
            case None =>
              Ok(s"Hello $to from docker container")
          }
        }
    }
  }
}
Server.run

synchronized {
  wait()
}
