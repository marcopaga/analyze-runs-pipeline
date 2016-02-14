(ns analyze-runs-pipeline.pipeline
  (:use [lambdacd.steps.control-flow]
        [analyze-runs-pipeline.steps])
  (:require
        [lambdacd.steps.manualtrigger :as manualtrigger]))

(def pipeline-def
  `(
    (either
     lambdacd.steps.manualtrigger/wait-for-manual-trigger
          wait-for-repo)
    (with-repo
      run-tests)))
