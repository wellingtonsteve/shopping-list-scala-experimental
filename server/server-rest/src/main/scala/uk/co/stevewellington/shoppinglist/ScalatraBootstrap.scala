package uk.co.stevewellington.shoppinglist

import javax.servlet.ServletContext

import org.scalatra.LifeCycle

class ScalatraBootstrap extends LifeCycle {
    
    override def init(context: ServletContext) {
        context.mount(new RestServer(null), "/*")
    }

}
