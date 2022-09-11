function up() {
	eval "docker image prune"
	eval "docker-compose up --build"
}

$1