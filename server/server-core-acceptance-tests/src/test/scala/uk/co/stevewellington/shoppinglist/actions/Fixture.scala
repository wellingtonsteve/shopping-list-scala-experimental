package uk.co.stevewellington.shoppinglist.actions

import com.flextrade.jfixture.JFixture

import scala.reflect.Manifest

trait Fixture {

  val fixture = new JFixture

  def fixture[T <: AnyRef](implicit manifest: Manifest[T]): T = {
    fixture.create(manifest.runtimeClass.asInstanceOf[Class[T]])
  }

}
