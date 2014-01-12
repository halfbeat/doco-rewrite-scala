package doco.rewrite

import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider
import org.ocpsoft.rewrite.config.{Configuration, ConfigurationBuilder}
import javax.servlet.ServletContext
import org.ocpsoft.rewrite.servlet.config.rule.Join
import java.security.Principal
import javax.inject.Inject

class RewriteConfiguration extends HttpConfigurationProvider {
  def priority(): Int = {
    10;
  }

  @Inject
  private var principal: Principal = _

  def getConfiguration(context: ServletContext): Configuration = {
    ConfigurationBuilder.begin().
      addRule(Join.path("/login").to("/login.xhtml"))
  }
}