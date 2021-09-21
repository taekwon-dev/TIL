# HttpServletRequest

\# 클라이언트 IP 

```
/**
 * Returns the Internet Protocol (IP) address of the client or last proxy
 * that sent the request. For HTTP servlets, same as the value of the CGI
 * variable <code>REMOTE_ADDR</code>.
 *
 * @return a <code>String</code> containing the IP address of the client
 *         that sent the request
 */
public String getRemoteAddr();
```

\# 클라이언트 User-Agent From Header 

