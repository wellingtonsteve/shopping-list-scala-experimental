package uk.co.stevewellington.shoppinglist.testutils

import com.flextrade.jfixture.JFixture

import scala.reflect.Manifest

trait Fixture {

  val fixture = new JFixture

  def fixture[T <: AnyRef](implicit manifest: Manifest[T]): T = {
    fixture.create(manifest.runtimeClass.asInstanceOf[Class[T]])
  }

}
