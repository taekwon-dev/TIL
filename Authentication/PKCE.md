# PKCE (Proof Key for Code Exchange)

\# Code Verifier \# Code Challenge

> The PKCE-enhanced Authorization Code Flow introduces a secret created by the calling application that can be verified by the authorization server; this secret is called the **<u>Code Verifier</u>**. Additionally, the calling app creates a transform value of the Code Verifier called the <u>**Code Challenge**</u> and sends this value over HTTPS to retrieve an Authorization Code. This way, a malicious attacker can only intercept the Authorization Code, and they cannot exchange it for a token without the Code Verifier.





### | Reference

###### https://auth0.com/docs/authorization/flows/authorization-code-flow-with-proof-key-for-code-exchange-pkce

