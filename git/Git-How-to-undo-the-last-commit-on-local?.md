# How to undo the last commit on local?

https://devconnected.com/how-to-undo-last-git-commit/



In this tutorial, we are going to see how you can easily undo the last commit, maybe to re-commit changes later on. 



### Undo Last Git Commit with reset

The easiest way to undo the last Git commit is to execute the “git reset” command with the “–soft” option that **will preserve changes done to your files**. You have to specify the commit to undo which is “HEAD~1” in this case.

```
// The last commit will be removed from your Git history.
$ git reset --soft HEAD~1 
```

If you are not familiar with this notation, “**HEAD~1**” means that you want to reset the HEAD (the last commit) to one commit before in the log history.

```
$ git log --oneline
```



### Undo Last Git Commit with revert 

