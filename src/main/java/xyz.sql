2023-08-07 14:35:22,874 INFO  {http-nio-8080-exec-7} [.r.p.e.s.t.i.OrderTransactionServiceImpl] initiateTransactionV2 request InitiateTransactionRequestData(sourceId=98901593551234214, wallet=false, orders=[Order(orderId=56918227, amount=137.88, netPayableAmount=null, orderNo=04567131, requestType=Advance)], paymentProvider=AJIO_BALANCE, paymentMode=AJIO_BALANCE, amount=137.88, txnMode=REGULAR, metadata=null, ajioDhanId=null, tenant=Tenant(super=com.ril.payment.engine.client.model.tenant.Tenant@2b9579dc, code=AJIO_BUSINESS, name=null, description=null, imageURL=null, callbackUrl=null, s2sCallbackUrl=null, tenantApplicationUrl=null, tncUrl=null), customer=Customer(uuid=98901593551234214, firstName=Name, lastName=Name, email=null, mobile=+919876543210, otp=null, fullName=null, userType=SSH, userStatus=ACIVE, city=City, state=State, isocode=123456, assignedRoles=null), paymentChannelInformation=PaymentChannelInformation(super=com.ril.payment.engine.client.request.PaymentChannelInformation@1972bdc8, paymentChannel=WEB, appType=OTHER, ip=null, referer=https://uat.b2b.ril.com/, userAgent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/112.0), accessToken=AJIO_BUSINESS_ACCESS_123, referer=https://uat.b2b.ril.com/, origin=https://uat.b2b.ril.com, platform=null, userAgent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/112.0, appType=OTHER, channel=WEB, host=10.160.253.77:8080, requestChecksum=null, callbackUrl=null, successRedirectUrl=null, failureRedirectUrl=null, transactionType=null, currency=null, merchantId=null, transactionToken=tx_tk_8a6d91e2-3501-11ee-ad59-f9df26567099)
2023-08-07 14:35:22,877 INFO  {http-nio-8080-exec-7} [.r.p.e.s.t.i.OrderTransactionServiceImpl] Saving the Order Txn details in DB for Txn id : REG0184003175008113248675224539822322156605
2023-08-07 14:35:23,025 INFO  {http-nio-8080-exec-7} [.r.p.e.s.t.i.OrderTransactionServiceImpl] payment collection initiated for AJIO_BALANCE for InitiateTransactionRequestData(sourceId=98901593551234214, wallet=false, orders=[Order(orderId=56918227, amount=137.88, netPayableAmount=null, orderNo=04567131, requestType=Advance)], paymentProvider=AJIO_BALANCE, paymentMode=AJIO_BALANCE, amount=137.88, txnMode=REGULAR, metadata=null, ajioDhanId=null, tenant=Tenant(super=com.ril.payment.engine.client.model.tenant.Tenant@2b9579dc, code=AJIO_BUSINESS, name=null, description=null, imageURL=null, callbackUrl=null, s2sCallbackUrl=null, tenantApplicationUrl=null, tncUrl=null), customer=Customer(uuid=98901593551234214, firstName=Name, lastName=Name, email=null, mobile=+919876543210, otp=null, fullName=null, userType=SSH, userStatus=ACIVE, city=City, state=State, isocode=123456, assignedRoles=null), paymentChannelInformation=PaymentChannelInformation(super=com.ril.payment.engine.client.request.PaymentChannelInformation@1972bdc8, paymentChannel=WEB, appType=OTHER, ip=null, referer=https://uat.b2b.ril.com/, userAgent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/112.0), accessToken=AJIO_BUSINESS_ACCESS_123, referer=https://uat.b2b.ril.com/, origin=https://uat.b2b.ril.com, platform=null, userAgent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/112.0, appType=OTHER, channel=WEB, host=10.160.253.77:8080, requestChecksum=null, callbackUrl=null, successRedirectUrl=null, failureRedirectUrl=null, transactionType=null, currency=null, merchantId=null, transactionToken=tx_tk_8a6d91e2-3501-11ee-ad59-f9df26567099)
2023-08-07 14:35:23,026 ERROR {http-nio-8080-exec-7} [.r.p.e.s.t.i.OrderTransactionServiceImpl] Exception while payment collection for, order  [Order(orderId=56918227, amount=137.88, netPayableAmount=null, orderNo=04567131, requestType=Advance)], amount 137.88
2023-08-07 14:35:23,031 INFO  {http-nio-8080-exec-7} [c.r.p.e.s.h.impl.CheckSumHelperImpl     ] checksum payload for initiateTransactionV2 is AJIO_BUSINESS|REG0184003175008113248675224539822322156605|https://uat.b2b.ril.com/rrlmpcommercewebservices/v2/rrlmp/payment/return|NA|98901593551234214|NA|+919876543210|NA|REG0184003175008113248675224539822322156605|137.88|NA|tx_tk_8a6d91e2-3501-11ee-ad59-f9df26567099|AJIO_BUSINESS_ACCESS_123|NA|NA


INSERT INTO PAYMENT_ENGINE_CONFIG (PAYMENT_ENGINE_CONFIG_ID, KEY, VALUE, DESCRIPTION, CREATED_DATE, MODIFIED_DATE, CREATED_BY, UPDATED_BY)
VALUE(SELECT MAX(PAYMENT_ENGINE_CONFIG_ID) + 1 from PAYMENT_ENGINE_CONFIG, 'FETCH_PI_FOR_PAYMENT_COLLECTION', 
'CARD,NET_BANKING,UPI,WALLET', 'Comman separated payment instruments');