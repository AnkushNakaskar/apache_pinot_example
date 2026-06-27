### Apache pinot installation steps

```
brew install pinot

/opt/homebrew/opt/pinot/bin/pinot-admin QuickStart -type BATCH -dataDir /opt/homebrew/var/lib/pinot/data


/opt/homebrew/opt/pinot/bin/pinot-admin StartZookeeper -zkPort 2181


/opt/homebrew/opt/pinot/bin/pinot-admin StartController -zkAddress localhost:2181 -controllerPort 9000

/opt/homebrew/opt/pinot/bin/pinot-admin StartBroker -zkAddress localhost:2181

/opt/homebrew/opt/pinot/bin/pinot-admin StartServer -zkAddress localhost:2181

http://localhost:9000
```



