(ns analyze-runs-pipeline.steps
  (:require [lambdacd.steps.shell :as shell]
            [lambdacd.steps.git :as git]))

(def repo "https://github.com/marcopaga/analyze-runs.git")

(defn wait-for-repo [_ ctx]
  (git/wait-for-git ctx repo "master"))

(defn with-repo [& steps]
  (git/with-git repo steps))

(defn run-tests [{cwd :cwd} ctx]
  (shell/bash ctx cwd
    "lein test"))





