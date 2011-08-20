Lunch and Learn - Creating a Java EE 6 application in OpenShift
===============================================================

This is an OpenShift example application for GSS lunch and learn. The application is based on Java EE 6 specification developed using Weld and Seam 3 Portable extensions.

Running on OpenShift
--------------------

Create an account at http://openshift.redhat.com/

Create a jbossas-7.0 application

    rhc-create-app -a lunchandlearn -t jbossas-7.0

Add this upstream lunch-and-learn repo

    cd lunchandlearn
    git remote add upstream -m master git://github.com/rimolive/lunch-and-learn.git
    git pull -s recursive -X theirs upstream master

Then push the repo upstream

    git push

That's it, you can now checkout your application at:

    http://lunchandlearn-$yourlogin.rhcloud.com
