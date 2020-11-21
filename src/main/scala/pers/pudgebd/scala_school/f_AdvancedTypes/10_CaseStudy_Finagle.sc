//trait Service[-Req, +Rep] extends (Req => Future[Rep])
//
//trait Filter[-ReqIn, +RepOut, +ReqOut, -RepIn]
//        extends ((ReqIn, Service[ReqOut, RepIn]) => Future[RepOut]) {
//    def andThen[Req2, Rep2](next: Filter[ReqOut, RepIn, Req2, Rep2]) =
//        new Filter[ReqIn, RepOut, Req2, Rep2] {
//            def apply(request: ReqIn, service: Service[Req2, Rep2]) = {
//                Filter.this.apply(request, new Service[ReqOut, RepIn] {
//                    def apply(request: ReqOut): Future[RepIn] = next(request, service)
//
//                    override def release() = service.release()
//
//                    override def isAvailable = service.isAvailable
//                })
//            }
//        }
//
//    def andThen(service: Service[ReqOut, RepIn]) = new Service[ReqIn, RepOut] {
//        private[this] val refcounted = new RefcountedService(service)
//
//        def apply(request: ReqIn) = Filter.this.apply(request, refcounted)
//
//        override def release() = refcounted.release()
//
//        override def isAvailable = refcounted.isAvailable
//    }
//}

//一个服务可以通过过滤器对请求进行身份验证。

//trait RequestWithCredentials extends Request {
//    def credentials: Credentials
//}
//
//class CredentialsFilter(credentialsParser: CredentialsParser)
//        extends Filter[Request, Response, RequestWithCredentials, Response]
//{
//    def apply(request: Request, service: Service[RequestWithCredentials, Response]): Future[Response] = {
//        val requestWithCredentials = new RequestWrapper with RequestWithCredentials {
//            val underlying = request
//            val credentials = credentialsParser(request) getOrElse NullCredentials
//        }
//
//        service(requestWithCredentials)
//    }
//}


//注意底层服务是如何需要对请求进行身份验证的，而且还是静态验证。因此，过滤器可以被看作是服务转换器。
//
//许多过滤器可以被组合在一起：

//val upFilter =
//    logTransaction     andThen
//            handleExceptions   andThen
//            extractCredentials andThen
//            homeUser           andThen
//            authenticate       andThen
//            route