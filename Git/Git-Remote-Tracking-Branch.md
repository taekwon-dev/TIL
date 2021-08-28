# Remote Tracking Branch



### | Remote Tracking Branch 

> Remote-tracking branches are references to the state of remote branches. They're local references that you can't move; Git moves them for you <u>whenever</u> <u>you do</u> any network communication, to make sure they accurately represent the state of the remote repository. Think of them as bookmarks, to remind you where the branches in your remote repositories were the last time you connected to them. 

### | Tracking Branch 

> Checking out a local branch from a remote-tracking branch automatically creates what is called a "tracking branch" (and the branch it tracks is called an "upstream branch"). Tracking branches are local branches that have a direct relationship to a remote branch. If you're on a tracking branch and type `git pull`, Git automatically knows which server to fetch from and which branch to merge in. 

### | Reference

###### https://git-scm.com/book/en/v2/Git-Branching-Remote-Branches
