cryptsy-api
===========

An implementation of the Cryptsy API in Java.

Example Usage
===========

To use it just:

```java
CryptsyApi api = new MixedCryptsyApi("publick key","private key");
api.exec(new XXXXReuqest());
```

If you only want to use public api

```java
CryptsyApi api = new PublicCryptsyApi();
api.exec(new XXXXRequest());
```

Or Authenticated api

```java
CryptsyApi api = new AuthenticatedCryptsyApi("publick key","private key");
api.exec(new XXXXRequest());
```

Donations ;)
===========

 BTC: 1Bg5ZZjQmdJThTjS9X5a4GyBaFQGsBvkJF
 
DOGE: DFbc5tgGmj6nvVgTg3EcURsk9oN4SxGXe9


License
===========

MIT License
