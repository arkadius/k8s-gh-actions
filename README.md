# Project showing multiple k8s Github Actions setup

## Docker image

Tests are invoked on sample [Play](https://www.playframework.com/) service runned by [Ammonite Script](https://ammonite.io/). You can find the source code in `sample-service` directory.

## K8s resources

Sample resourcs (deployment, service, ingress) are available in `kubectl-playground` directory.

## Pipeline

CI Pipeline tests multiple k8s plugins:
* [k3d plugin](https://github.com/AbsaOSS/k3d-action)
* [k3s plugin](https://github.com/debianmaster/actions-k3s)
* [microk8s plugin](https://github.com/balchua/microk8s-actions)

See `.github/workflow/test.yml` for details