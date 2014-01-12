package doco.rewrite

import javax.enterprise.inject.{Default, Produces}
import java.security.Principal
import javax.inject.Named
import doco.cdi.Eager
import javax.enterprise.context.{RequestScoped, ApplicationScoped}
import javax.annotation.PostConstruct

@Eager
@ApplicationScoped
class CDIBuilders {

  @PostConstruct
  def init() {
    println("Hooola")
  }

  @Produces
  @Named("principal")
  @RequestScoped
  def principal(): Principal = {
    new Principal {
      def getName: String = "Angel"
    }
  }
}
