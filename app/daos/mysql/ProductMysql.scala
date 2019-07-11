package daos.mysql

import com.google.inject.Inject
import daos.ProductDAO
import daos.tables.ProductTable
import play.api.db.slick.DatabaseConfigProvider
import slick.lifted.TableQuery

class ProductMysql @Inject()(
  protected val dbConfigProvider: DatabaseConfigProvider
) extends BaseMysql[ProductTable, Product](TableQuery[ProductTable]) with ProductDAO
